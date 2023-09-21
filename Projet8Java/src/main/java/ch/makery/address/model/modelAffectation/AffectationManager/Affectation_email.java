package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import javafx.event.ActionEvent;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Affectation_email {
    public static void envoyerEmail(String numEmp) throws SQLException {
        Connection con = null;

        String selectQuery = "SELECT employe.civilite, employe.nom, employe.prenom,employe.mail,employe.poste, employe.lieu, affecter.numAffect,affecter.nouveauLieu, affecter.datePriseService\n" +
                "\tFROM public.employe  LEFT JOIN AFFECTER on employe.numEmp = affecter.numEmp WHERE affecter.numEmp = ?";

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

            String text = civilite + " " + nom + " " + prenom + " , qui occupe le poste de " + poste + " à  " + lieu + ", nous vous affectons à " +
                    nouveauLieu + " pour compter de la date de prise de service " + datePriseService + ".\n\n" +
                    "Le présent communiqué sera enregistré et communiqué partout où besoin sera.";


            String host = "smtp.gmail.com";
            String port = "587";
            String username = "cheaterrandriasony@gmail.com";
            String password = "dmafllineecsodcb";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);

            Session session = Session.getInstance(props);

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
                message.setSubject("Lettre d'affectation");
                message.setText(text);

                Transport transport = session.getTransport("smtp");
                transport.connect(host, Integer.parseInt(port), username, password);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                System.out.println("Email sent successfully.");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
