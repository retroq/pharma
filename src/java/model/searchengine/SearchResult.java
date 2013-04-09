/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.searchengine;

import entity.Drug;
import java.util.List;

/**
 *
 * @author anton
 */
public class SearchResult {

    List<Drug> foundByRealiseName, 
            foundByCompany, 
            foundByActiveComponent;

    public SearchResult(List<Drug> foundByRealiseName, List<Drug> foundByCompany, List<Drug> foundByActiveComponent) {
        this.foundByRealiseName = foundByRealiseName;
        this.foundByCompany = foundByCompany;
        this.foundByActiveComponent = foundByActiveComponent;
    }
    
    public boolean isEmpty(){
        return foundByActiveComponent.isEmpty() && 
                foundByCompany.isEmpty() &&
                foundByRealiseName.isEmpty();
    }

    public List<Drug> getFoundByActiveComponent() {
        return foundByActiveComponent;
    }

    public void setFoundByActiveComponent(List<Drug> foundByActiveComponent) {
        this.foundByActiveComponent = foundByActiveComponent;
    }

    public List<Drug> getFoundByCompany() {
        return foundByCompany;
    }

    public void setFoundByCompany(List<Drug> foundByCompany) {
        this.foundByCompany = foundByCompany;
    }

    public List<Drug> getFoundByRealiseName() {
        return foundByRealiseName;
    }

    public void setFoundByRealiseName(List<Drug> foundByRealiseName) {
        this.foundByRealiseName = foundByRealiseName;
    }
    
    
}
