package com.ams.ms.generic.pojo;


import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class APIResponse {

    @Autowired
    private CustomMessageSource messageSource;

    @NotNull
    private boolean status;
    @NotNull
    private String message;

    private Object data;

    private Object errors;

    public APIResponse(boolean status, String message, Object data) {
        this.status =status;
        this.message = message;
        this.data= data;
    }
    public APIResponse successResponse(String message, Object data){
        /*this.message = message;
        this.data= data;
        this.status=true;*/
        return new APIResponse(true, message, data);
    }
    public ResponseEntity<?> saveSuccess(String message, Object data){
        this.message = messageSource.get("success.save",message);
        return new ResponseEntity(successResponse(this.message,data), HttpStatus.CREATED);
    }
    public ResponseEntity<?> updateSuccess(String message, Object data){
        this.message = messageSource.get("success.update",message);
        return new ResponseEntity(successResponse(this.message,data), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<?> deleteSuccess(String message, Object data){
        this.message = messageSource.get("success.delete",message);
        return new ResponseEntity(successResponse(this.message,data), HttpStatus.OK);
    }
    public ResponseEntity<?> getSuccess(String message, Object data){
        this.message = messageSource.get("success.get",message);
        return new ResponseEntity(successResponse(this.message,data), HttpStatus.OK);
    }

}
