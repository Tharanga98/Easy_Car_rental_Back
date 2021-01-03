package lk.EasyCarRental.advisor;


import lk.EasyCarRental.util.StandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleMethod(Exception ex){
        StandedResponse response=new StandedResponse(500,"Internal Server Error..",ex.getMessage());
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
