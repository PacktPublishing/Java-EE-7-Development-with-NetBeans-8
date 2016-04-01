/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.ejbtimer.ejb;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author heffel
 */
@Stateless
@LocalBean
public class EjbTimerDemo {

    @Schedule(hour = "*", minute = "*", second = "*/30")
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
