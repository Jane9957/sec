package app.servies;

import app.dataBase.DataBaseTemplate;
import app.servies.entities.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private DataBaseTemplate dataBaseTemplate;

    public List<Template> getTemplates() {
        List<Template> templates = new ArrayList<>();
        try {
            templates = dataBaseTemplate.getTemplates();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return templates;
    }

    public void createTemplate(Template template) throws SQLException {
        try {
            dataBaseTemplate.createTemplate(template);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
