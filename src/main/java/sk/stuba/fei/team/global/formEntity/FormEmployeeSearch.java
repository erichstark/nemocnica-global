package sk.stuba.fei.team.global.formEntity;

/**
 * Created by jakubrehak on 06/05/15.
 */
public class FormEmployeeSearch extends  GenericSearchForm {


    private String name;
    private String surname;

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

}
