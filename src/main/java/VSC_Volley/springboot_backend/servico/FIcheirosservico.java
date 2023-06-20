package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Ficheiros;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FIcheirosservico {

    public Ficheiros store(MultipartFile file) throws IOException;

    public Stream<Ficheiros> getAllFiles();

    public boolean gerar() throws IOException;

    public void delete (int index);
}
