package sk.stuba.fei.nemocnica.formEntity;

/**
 * Created by pallo on 5/3/15.
 */
public class FormAmbulancia {
    private Long id;
    private String name;
    private Long id_zariadenie;

    public FormAmbulancia() {
    }

    public FormAmbulancia(Long id, String name, Long id_zariadenie) {
        this.id = id;
        this.name = name;
        this.id_zariadenie = id_zariadenie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_zariadenie() {
        return id_zariadenie;
    }

    public void setId_zariadenie(Long id_zariadenie) {
        this.id_zariadenie = id_zariadenie;
    }
}
