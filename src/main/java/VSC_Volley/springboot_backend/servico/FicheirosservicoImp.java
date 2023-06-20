package VSC_Volley.springboot_backend.servico;

import VSC_Volley.springboot_backend.modelo.Ficheiros;
import VSC_Volley.springboot_backend.modelo.Jogador;
import VSC_Volley.springboot_backend.modelo.Jogos;
import VSC_Volley.springboot_backend.repositorio.Ficheirosrepositorio;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.itextpdf.kernel.colors.DeviceRgb.RED;

@Service
public class FicheirosservicoImp implements FIcheirosservico {
    @Autowired
    private Ficheirosrepositorio fileDBRepository;
    @Autowired
    private JogosServico jogoServico;
    @Autowired
    private JogadorServico equipa;

    public Ficheiros store(@NotNull MultipartFile file) throws IOException {
        String ficheironome = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Ficheiros FileDB = new Ficheiros(ficheironome, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    }

    public Ficheiros getFile(String id) {
        if(fileDBRepository.findById(id).isPresent()) {
            return fileDBRepository.findById(id).get();
        }
        return null;
    }

    public Stream<Ficheiros> getAllFiles() {
        return fileDBRepository.findAll().stream().sorted(this::compare);
    }

    public boolean gerar() throws IOException {
        Jogos jogos= jogoServico.detalhes();
        String DEST = "C:/Users/pedro/Desktop/hello.pdf";
        String pontos=jogos.getResul1()+" - "+jogos.getResul2();
        String eq=jogos.getEquipa1();
        String eq2=jogos.getEquipa2();


        List<Jogador> jogadores= equipa.imprimir();


        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        Document document = new Document(pdf);


        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter data1 =DateTimeFormatter.ofPattern("HH:mm:ss");

        Paragraph p = new Paragraph("Relatorio de Jogo"+"  "+data.format(now))
                .setBold()
                .setFontColor(new DeviceRgb(8, 73, 117))
                .setFontSize(30f);
        p.getAccessibilityProperties().setRole(StandardRoles.H1);
        document.add(p);

        Paragraph p1 = new Paragraph(eq+"\t"+pontos+"\t"+eq2)
                .setFontColor(new DeviceRgb(0, 128, 0))
                .setFontSize(20f);
        p.getAccessibilityProperties().setRole(StandardRoles.H2);
        document.add(p1);

        Table table= new Table(3).setTextAlignment(TextAlignment.CENTER).useAllAvailableWidth().setFontSize(9f);
        table.addHeaderCell("Nome");
        table.addHeaderCell("Pontos");
        table.addHeaderCell("Tempo");

        int b=1;
        int j=0;
        while(j<6) {
            for(int i=1;i<5;i++) {
                if (i == 1) {
                    if (b == 1) {
                        table.addCell(jogos.getJogador1());
                    }
                    if (b == 2) {
                        table.addCell(jogos.getJogador2());
                    }
                    if (b == 3) {
                        table.addCell(jogos.getJogador3());
                    }
                    if (b == 4) {
                        table.addCell(jogos.getJogador4());
                    }
                    if (b == 5) {
                        table.addCell(jogos.getJogador5());
                    }
                    if (b == 6) {
                        table.addCell(jogos.getJogador6());
                    }

                }
                if (i == 2){
                    if (b == 1) {
                        table.addCell(String.valueOf(jogos.getNumPontos1()));
                        }
                    if (b == 2) {
                        table.addCell(String.valueOf(jogos.getNumPontos2()));
                    }
                    if (b == 3) {
                        table.addCell(String.valueOf(jogos.getNumPontos3()));
                    }
                    if (b == 4) {
                        table.addCell(String.valueOf(jogos.getNumPontos4()));
                    }
                    if (b == 5) {
                        table.addCell(String.valueOf(jogos.getNumPontos5()));
                    }
                    if (b == 6) {
                        table.addCell(String.valueOf(jogos.getNumPontos6()));
                    }
                }
                if(i==3) {
                    if (b == 1) {
                        table.addCell(jogos.getTempojogo1());
                    }
                    if (b == 2) {
                        table.addCell(jogos.getTempojogo2());
                    }
                    if (b == 3) {
                        table.addCell(jogos.getTempojogo3());
                    }
                    if (b == 4) {
                        table.addCell(jogos.getTempojogo4());
                    }
                    if (b == 5) {
                        table.addCell(jogos.getTempojogo5());
                    }
                    if (b == 6) {
                        table.addCell(jogos.getTempojogo6());
                    }
                }
            }
            b++;
            j++;
        }


        Table table1 = new Table(4).setTextAlignment(TextAlignment.CENTER).useAllAvailableWidth().setBackgroundColor(new DeviceRgb(116,209,249)).setBorder(Border.NO_BORDER);
        table1.addHeaderCell("Sets");
        table1.addHeaderCell("Tempo");
        table1.addHeaderCell("Parciais");
        table1.addHeaderCell("Pontos");
        int l=0;
        j=1;
        while(l<4) {
            for(int i=1;i<5;i++){
                if(i==1) {
                    table1.addCell(String.valueOf(j));
                    j++;
                }
                else
                    if(i==2){
                    table1.addCell("30'");}
                    if(i==3){table1.addCell("8-5 | 13-15 | 19-21");}
                    if(i==4){table1.addCell("25-19");}
                }
            ++l;
        }
        table1.addCell("5");
        for(int i=0;i<3;i++){
            if(i==0){table1.addCell("26'");}
            if(i==1){table1.addCell("8-10 | 12-14 | 25-15");}
            if(i==2){table1.addCell("18-25");}
        }
        table1.addCell("Total");
        for(int i=0;i<3;i++){
            if(i==0){table1.addCell("22'");}
            if(i==1){table1.addCell("7-9 | 10-15 | 25-18");}
            if(i==2){table1.addCell("17-25");}
        }


        Table table2= new Table(1).setAutoLayout()
                .setBorder(Border.NO_BORDER)
                .setBackgroundColor(new DeviceRgb(82,150,228));
        table2.addCell("").setBorder(Border.NO_BORDER).setWidth(450f).setHeight(0.5f);


        Table table3 = new Table(5).setAutoLayout();
        table3.addHeaderCell("Evolução do resultado");
        int h=0;
        while(h<4){
            if(jogos.getResul1()>jogos.getResul2())
                table3.addHeaderCell("+");
            else
                table3.addHeaderCell("-");
        h++;}
        
        Paragraph p2= new Paragraph();
        int z=0;

        String [] jog= equipa.nomes();
        String [] jog2 = new String[]{jogos.getJogador1(), jogos.getJogador2(), jogos.getJogador3() , jogos.getJogador4() , jogos.getJogador5() , jogos.getJogador6()};
        String [] paragrafo = new String[jog.length];

        for(b=0;b<paragrafo.length;b++) {
            while (z < (jog2.length)) {
                if (!(jog[b].equals(jog2[z])) && !jog[b].isEmpty())
                    paragrafo[b] = jog[b];
                z++;
            }
        }
        b=0;
        String a = null;
        while(b<paragrafo.length) {
            if (paragrafo[b] != null && b==0) {
                a = paragrafo[b];
                a += ",";
            }
            else if(paragrafo[b] != null){
                a = paragrafo[b];
                a+=",";
            }
            b++;
        }
        p2.add(a);

        Table tabela4= new Table(9).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(RED).setHeight(200f);
        for(h=1;h<4;h++) {
          int  i=1;
            while (i <10) {
                if (i ==2 && h==1) {
                    tabela4.addCell("-X-").setWidth(300f);
                    i++;
                }
                if (i ==4 && h==3) {
                    tabela4.addCell("-X-");
                    i++;
                }
                else if(i==5) {
                    tabela4.addCell("-").setWidth(50f);
                    i++;
                }
                else {
                    tabela4.addCell("---").setWidth(300f).setBackgroundColor(RED);
                    i++;
                }

            }
        }


        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Evolução Jogo").setFontColor(new DeviceRgb(43,173,199)).setFontSize(15f).setBold().setUnderline());
        document.add(table1);
        document.add(new Paragraph("\n"));
        document.add(table3);
        document.add(new Paragraph("\n"));
        document.add(table2);
        document.add(new Paragraph("Estatistica Jogadores").setFontColor(new DeviceRgb(43,173,199)).setFontSize(15f).setBold().setUnderline());
        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(table2);
        document.add(new Paragraph("Jogadores Ausentes").setFontColor(new DeviceRgb(43,173,199)).setFontSize(15f).setBold().setUnderline());
        document.add(p2);
        document.add(table2);
        document.add(new Paragraph("Pontos fracos da defesa").setFontColor(new DeviceRgb(43,173,199)).setFontSize(15f).setBold().setUnderline());
        document.add(new Paragraph(eq+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+eq2));
        document.add(tabela4);
        document.close();

        Path pdfPath = Paths.get(DEST);

        String name = "Relatorio_"+data.format(now)+"_"+data1.format(now)+".pdf";
        String originalFileName = "Relatorio  "+ eq+" vs "+eq2+"  "+data.format(now)+".pdf";
        String contentType = "application/pdf";
        byte[] content;
        try {
            content = Files.readAllBytes(pdfPath);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        MultipartFile result = new MockMultipartFile(name,
                originalFileName, contentType, content);
        store(result);
        File file1= new File(DEST);

        return  file1.delete();
    }

    public int compare(@NotNull Ficheiros f1, @NotNull Ficheiros f2){
        String a= f1.getNome();
        String b= f2.getNome();
        return a.compareToIgnoreCase(b);
    }
    public void delete (int index){
        List<Ficheiros> files=fileDBRepository.findAll();
        files.sort(this::compare);
        Ficheiros ficheiro= files.get(index);

            if(!(ficheiro == null)) {
                files.remove(ficheiro);
                fileDBRepository.deleteAll();
                fileDBRepository.saveAll(files);
            }
    }

}
