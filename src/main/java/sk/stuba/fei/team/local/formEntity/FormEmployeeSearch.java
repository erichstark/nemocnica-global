package sk.stuba.fei.team.local.formEntity;

/**
 * Created by jakubrehak on 06/05/15.
 */
public class FormEmployeeSearch extends  GenericSearchForm {


    private String name;
    private String surname;
    private String specialization;
    private String town;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
