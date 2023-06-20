package VSC_Volley.springboot_backend.controle;

import VSC_Volley.springboot_backend.menssagem.Mensagem;
import VSC_Volley.springboot_backend.menssagem.RespostaFicheiro;
import VSC_Volley.springboot_backend.modelo.Ficheiros;
import VSC_Volley.springboot_backend.modelo.Reverse;
import VSC_Volley.springboot_backend.servico.FicheirosservicoImp;
import VSC_Volley.springboot_backend.servico.JogosServico;
import com.itextpdf.io.exceptions.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@CrossOrigin
@RequestMapping("/Ficheiros")
public class ControlFicheiros {
    @Autowired
    private FicheirosservicoImp storageService;
    private JogosServico jogosS;

    @PostMapping("/upload")
    public ResponseEntity<Mensagem> uploadFile(@RequestParam("file") MultipartFile file) {
        String mensagem;

        try {
            storageService.store(file);

            mensagem = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new Mensagem(mensagem));
        } catch (Exception e) {
            mensagem = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Mensagem(mensagem));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<RespostaFicheiro>> getListFiles() {
        List<RespostaFicheiro> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = "https://www.phpmyadmin.co/tbl_get_field.php?db=sql7614843&table=ficheiros&where_clause=%60ficheiros%60.%60id%60+%3D+%27"+dbFile.getId()+"%27&transform_key=data&sql_query=SELECT+%2A+FROM+%60ficheiros%60";
            return new RespostaFicheiro(
                    dbFile.getNome(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());


        return ResponseEntity.status(HttpStatus.OK).body(files);
    }


    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Ficheiros fileDB = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getNome() + "\"")
                .body(fileDB.getData());
    }

    @GetMapping("/pdf")
    public ResponseEntity<String> PDF() throws IOException, java.io.IOException {
        if(storageService.gerar())
            return new ResponseEntity<String>(HttpStatus.OK);
        else
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> del(Reverse r){
        storageService.delete(r.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
