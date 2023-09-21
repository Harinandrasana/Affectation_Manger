package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import javafx.scene.control.DatePicker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Affectation_pdf {
    public static void generer(String numEmp) throws IOException, SQLException {
        Connection con = null;

        String selectQuery = "SELECT employe.civilite, employe.nom, employe.prenom,employe.mail,employe.poste, employe.lieu, affecter.numAffect,affecter.nouveauLieu, " +
                "affecter.datePriseService FROM public.employe  LEFT JOIN AFFECTER on employe.numEmp = affecter.numEmp WHERE employe.numEmp = ?";

        con = DBConnexion.getConnection();
        PreparedStatement statement = con.prepareStatement(selectQuery);
        statement.setString(1, numEmp);

        ResultSet resultSet = statement.executeQuery();

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");

        String formattedDateTime = currentDateTime.format(formatter);

        if (resultSet.next()) {
            String civilite = resultSet.getString("civilite");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String mail = resultSet.getString("mail");
            String poste = resultSet.getString("poste");
            String lieu = resultSet.getString("lieu");
            String numAffect = resultSet.getString("numAffect");
            String nouveauLieu = resultSet.getString("nouveauLieu");
            String datePriseService = resultSet.getString("datePriseService");

            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDFont font = PDType1Font.HELVETICA;
            int fontSize = 12;
            float leading = 1.5f * fontSize; // Espacement entre les lignes

            float margin = 50; // Marge gauche
            float width = page.getMediaBox().getWidth() - 2 * margin; // Largeur de la zone de texte
            float startX = page.getMediaBox().getLowerLeftX() + margin; // Position horizontale de départ
            float startY = page.getMediaBox().getUpperRightY() - margin; // Position verticale de départ

            String text = "                                         Arrêté N°00" + numAffect + " du " + formattedDateTime +"\n" +
                    civilite + " " + nom + " " + prenom + " , qui occupe le poste de " + poste + " à " + lieu + " est affecté à " +
                    nouveauLieu + " pour compter de la date de prise de \n service " + datePriseService + ".\n\n" +
                    "Le présent communiqué sera enregistré et communiqué partout où besoin sera.";

            contentStream.setFont(font, fontSize);
            contentStream.setLeading(leading);
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);

            for (String line : text.split("\n")) {
                contentStream.showText(line);
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            File pdfFile = new File("Affectation 0" + numAffect + ".pdf");
            document.save(pdfFile);
            document.close();

            // Ouvrir le fichier PDF avec l'application par défaut
            Desktop.getDesktop().open(pdfFile);
        }
    }
}
