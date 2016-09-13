package controllers;

import models.db.FieldsDAO;
import models.entities.Field;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public Result index() {
        List<Field> emptyList = new FieldsDAO().getAllFields();
        return ok(editFields.render(emptyList));
    }

}
