package app.dataBase;

import app.servies.entities.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseTemplate {

    @Autowired
    private DataSource src;

    public List<Template> getTemplates() throws SQLException {
        List<Template> list = new ArrayList<>();
        Connection connection = src.getConnection();

        String GET_TEMPLATES = "{call getTemplates() }";

        CallableStatement callableStatement = connection.prepareCall(GET_TEMPLATES);

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                Template template = new Template();
                template.setTemplate_id(resultSet.getInt(1));
                template.setTemplateName(resultSet.getString(2));
                template.setSubject(resultSet.getString(3));
                template.setMessage(resultSet.getString(4));
                template.setDescription(resultSet.getString(5));
                template.setRate(resultSet.getFloat(6));
                list.add(template);

            }
        }
        callableStatement.execute();
        connection.close();

        return list;
    }

    public void createTemplate(Template template) throws SQLException {
        Connection connection = src.getConnection();

        String REGISTRATION_QUERY = "{call createTemplate(?, ?, ?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(REGISTRATION_QUERY);
        callableStatement.setString("templateName", template.getTemplateName());
        callableStatement.setString("subject", template.getSubject());
        callableStatement.setString("message", template.getMessage());
        callableStatement.setString("description", template.getDescription());
        callableStatement.setFloat("rate", template.getRate());

        callableStatement.execute();
        connection.close();
    }

    public Template getTemplateById(int template_id) throws SQLException {
        Connection connection = src.getConnection();

        String GET_TEMPLATE_BY_ID = "{ call getTemplateById(?) }";
        CallableStatement callableStatement = connection.prepareCall(GET_TEMPLATE_BY_ID);

        callableStatement.setInt("template_id", template_id);

        Template template = new Template();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                template.setTemplateName(resultSet.getString(2));
                template.setSubject(resultSet.getString(3));
                template.setMessage(resultSet.getString(4));
                template.setDescription(resultSet.getString(5));
                template.setRate((resultSet.getFloat(6)));
            }
        } catch (Exception e) {
            throw e;
        }

        connection.close();
        return template;
    }
}
