package sk.stuba.fei.team.local.formEntity;

/**
 * Created by jakubrehak on 06/05/15.
 */
public class GenericSearchForm {

    private int curPage;
    private String sortField;
    private String sortOrder;
    private int numFound;
    private int perPage=4;
    private String baseLink;


    public String getBaseLink() {
        return baseLink;
    }
    public void setBaseLink(String baseLink) {
        this.baseLink = baseLink;
    }
    public int getNumFound() {
        return numFound;
    }
    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }
    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public String getSortField() {
        return sortField;
    }
    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
