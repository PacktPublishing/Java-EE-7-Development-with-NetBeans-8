/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.sessionbeanintro.ejb;

import javax.ejb.Remote;

/**
 *
 * @author heffel
 */
@Remote
public interface EchoRemote {

    String echo(String saying);
    
}
