/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemark2.test;

import employeemark2.FTE;
import employeemark2.PTE;
import employeemark2.hashTable;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kaveen
 */
public class TestHashTable {

    @Test
    public void testHashTableFTE() {
        FTE e = new FTE(122, "Test", "Test", 1, 1, 1, 1);

        hashTable ht = new hashTable(5);
        ht.addToTable(e);
        assertEquals(e.getFirstName(), ht.search(122).getFirstName());

    }

    @Test
    public void testHashTablePTE() {
        PTE e = new PTE(123, "Test", "Test", 44, 2, 12, 4, 1, 3);
        hashTable ht = new hashTable(5);
        ht.addToTable(e);
        PTE e2 = (PTE) ht.search(123);
        assertEquals(e2.getHourlyWage(), e.getHourlyWage());

    }

}
