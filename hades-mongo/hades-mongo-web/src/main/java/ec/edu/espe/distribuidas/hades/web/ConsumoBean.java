/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.distribuidas.hades.web;

import ec.edu.espe.distribuidas.hades.enums.MenuEnum;
import ec.edu.espe.distribuidas.hades.model.Camarote;
import ec.edu.espe.distribuidas.hades.model.Consumo;
import ec.edu.espe.distribuidas.hades.model.Menu;
import ec.edu.espe.distribuidas.hades.model.TipoAlimentacion;
import ec.edu.espe.distribuidas.hades.model.Tour;
import ec.edu.espe.distribuidas.hades.service.ConsumoService;
import ec.edu.espe.distribuidas.hades.service.MenuService;
import ec.edu.espe.distribuidas.hades.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hades Cruise Corp.
 */
@Named
@ViewScoped
public class ConsumoBean extends BaseBean implements Serializable {

    private List<Menu> itemsMenu;
    private Consumo consumo;
    private Tour tour;
    private Camarote camarote;

    @Inject
    private MenuService menuService;

    @Inject
    private ConsumoService consumoService;

    @PostConstruct
    public void init() {
        this.itemsMenu = this.menuService.obtenerTodos();
        this.camarote = new Camarote();
        this.consumo = new Consumo();
    }

    public List<Menu> getItemsMenu() {
        return itemsMenu;
    }
    
    @Override
    public void agregar() {
        this.consumo = new Consumo();
        System.out.println("En Agregar");
        super.agregar();
        
    }

     public void guardar() {
        System.out.println("En guardar");
        try {
            if (this.enAgregar) {
                this.consumoService.crear(this.consumo);
                FacesUtil.addMessageInfo("Se agregó el Tipo de Alimentaci\u00f3n: ");
            } else {
                
                FacesUtil.addMessageInfo("Se modific\u00f3 el Tipo de Alimentaci\u00f3n con c\u00f3digo: " );
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.consumo = new Consumo();
    }

    public void cancelar() {
        super.reset();
        this.consumo = new Consumo();
    }

    public MenuEnum[] getTiposMenu() {
        return MenuEnum.values();
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Camarote getCamarote() {
        return camarote;
    }

    public void setCamarote(Camarote camarote) {
        this.camarote = camarote;
    }

}
