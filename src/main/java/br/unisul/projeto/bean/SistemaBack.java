package br.unisul.projeto.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.unisul.projeto.dao.SistemaDao;
import br.unisul.projeto.domain.Sistema;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class SistemaBack implements Serializable{
	
	
	private ArrayList<Sistema> listaArquivos = new ArrayList<Sistema>();

	Sistema sistema = new Sistema();
	
	
	//LISTAR
	@PostConstruct
	public void listarArquivos() {
		try {

			SistemaDao dao = new SistemaDao();
			listaArquivos = (ArrayList<Sistema>) dao.listarTodos();

		} catch (Exception e) {

			Messages.addGlobalInfo("Erro ao listar arquivos");
			e.printStackTrace();

		}
	}
	
	
	//new
	public void novo() {

		sistema = new Sistema();
		listarArquivos();

	}
	
	
	// faz upload para caminho temporário
	public void uploadFile(FileUploadEvent evento) {

		try {

			UploadedFile x = evento.getFile();
		
			Path temp = Files.createTempFile(null, null);
			Files.copy(x.getInputstream(), temp, StandardCopyOption.REPLACE_EXISTING);

			sistema.setPathTemp(temp.toString());
			
			//pega nome do arquivo
			String nomeArquivo = evento.getFile().getFileName();
			
			sistema.setSis_arquivo(nomeArquivo);
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}

		Messages.addGlobalInfo(sistema.getPathTemp());

	}
	
	
	private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(FileUploadEvent event) {
        file = event.getFile();

        if (file != null) {

            File file1 = new File("C:/Users/tiagoboeing/eclipse-workspace/projetoProgWeb/src/main/webapp/resources/uploads", file.getFileName()); 
           
            try {
                FileOutputStream fos = new FileOutputStream(file1);
                fos.write(event.getFile().getContents());
                fos.close();

                FacesContext instance = FacesContext.getCurrentInstance();
                instance.addMessage("mensagens", new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        file.getFileName() + " anexado com sucesso", null));
                
                
                // define arquivo no banco
                Sistema sis = new Sistema();
                sis.setSis_arquivo(file.getFileName());
                
                SistemaDao dao = new SistemaDao();
        		dao.salvaUpload(sis);
                
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            
        }
    }

	
	public void salvaArquivo() {
		
		SistemaDao dao = new SistemaDao();
		Sistema sis = dao.salvaUpload(sistema);

		Path origem = Paths.get(sistema.getPathTemp());
		Path destino = Paths.get("/resources/uploads/" + sis.getSis_id() + ".png");
		
		try {

			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro");
		}

		Messages.addGlobalInfo("Logomarca cadastrada com sucesso");

		sistema = new Sistema();

	}
	
	
	
	public void excluir(ActionEvent evt) {

		sistema = (Sistema) evt.getComponent().getAttributes().get("sistemaExcluir");
		SistemaDao dao = new SistemaDao();
		dao.excluirArquivo(sistema);
		listaArquivos = (ArrayList<Sistema>) dao.listarTodos();
		novo();
		listarArquivos();
		
	}
	
	

	
	// getters and setters
	public ArrayList<Sistema> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(ArrayList<Sistema> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}



	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
	
	

}
