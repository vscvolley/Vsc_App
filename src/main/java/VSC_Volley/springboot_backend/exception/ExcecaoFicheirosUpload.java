package VSC_Volley.springboot_backend.exception;

import VSC_Volley.springboot_backend.menssagem.Mensagem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ExcecaoFicheirosUpload {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Mensagem> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Mensagem("File too large!"));
    }
}
