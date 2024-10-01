
package com.senac.filmeWeb.Exception;

import org.springframework.http.HttpStatus; 

import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *
 * @author Maria Alice
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
        
    }
    
}
