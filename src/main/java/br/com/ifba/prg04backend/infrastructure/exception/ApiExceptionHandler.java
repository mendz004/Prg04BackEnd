package br.com.ifba.prg04backend.infrastructure.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Value( value = "${server.erro.inclue-exception:false}")
    private boolean printStackTrace;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(final BusinessException businessException, final WebRequest request) {

        final String menssageErro = businessException.getMessage();

        return construirMensagemDeErro(businessException, menssageErro, HttpStatus.BAD_REQUEST, request);
    }

    public ResponseEntity<Object> construirMensagemDeErro(Exception exception, String message, HttpStatus httpStatus, WebRequest request) {

        ApiError apiError = new ApiError();
        apiError.setTimesTamp(LocalDateTime.now());
        apiError.setStatus(httpStatus.value());
        apiError.setError(httpStatus.getReasonPhrase());
        apiError.setMessage(message);

        apiError.setPath(request.getDescription(false).replace("uri=", ""));

        if (printStackTrace) {
            // Forma nativa do Java para extrair a Stacktrace sem precisar da biblioteca ExceptionUtils
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);

            apiError.setStackTrace(stringWriter.toString());
        }
        return new ResponseEntity<>(apiError, httpStatus);
    }

}
