package sk.stuba.fei.team.local.formEntity;

/**
 * Created by pallo on 5/3/15.
 */
public class FormOffice {
    private Long id;
    private String name;
    private Long id_facility;

    public FormOffice() {
    }

    public FormOffice(Long id, String name, Long id_facility) {
        this.id = id;
        this.name = name;
        this.id_facility = id_facility;
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

    public Long getId_facility() {
        return id_facility;
    }

    public void setId_facility(Long id_facility) {
        this.id_facility = id_facility;
    }
}
