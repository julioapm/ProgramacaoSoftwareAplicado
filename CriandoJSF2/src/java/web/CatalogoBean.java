package web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.Catalogo;
import negocio.Produto;

/**
 *
 * @author Julio
 */
@Named
@SessionScoped
public class CatalogoBean implements Serializable{
    private Produto produto;
    private List<Produto> produtos;
    @Inject
    private Catalogo catalogo;
    
    @PostConstruct
    public void init(){
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        if(produtos == null){
            produtos = catalogo.listarTodos();
        }
        return produtos;
    }
    
    public String salvar(Produto umProduto) {
        FacesMessage msg = new FacesMessage("Produto " + umProduto.getCodigo() + " salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "index";
    }
}
