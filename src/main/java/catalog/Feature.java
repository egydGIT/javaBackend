/*
Feature interface: Ez az interfész jelzi, ha valaminek van címe, és vannak közreműködők.
Két metódussal rendelkező interface. A getContributors() visszaadja a katalógus elem közreműködőit
(szerzők és előadók is), valamint egy getTitle() metódus ami az elem címét adja vissza.
 */

package catalog;

import java.util.List;

public interface Feature {

    public List<String> getContributors();

    public String getTitle();

}
