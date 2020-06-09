/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.nativeAnimals.repository.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author csz
 */

@Entity
@NamedQueries({
    @NamedQuery(name = EndUsers.GET_ALL_QUERY_NAME, query = "SELECT e FROM EndUsers e order by e.userId desc")})
public class EndUsers extends Users {
    private int userId;
    
    
    
    
}
