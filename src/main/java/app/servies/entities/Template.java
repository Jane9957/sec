package app.servies.entities;

public class Template {

    private int template_id;
    private String templateName;
    private String message;
    private String description;
    private float rate;

    public int getTemplate_id() { return template_id; }
    public void setTemplate_id(int template_id) { this.template_id = template_id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public float getRate() { return rate; }
    public void setRate(float rate) { this.rate = rate; }

}
