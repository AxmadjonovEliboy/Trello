package uz.elmurodov.spring_boot.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/column/*")
public class ProjectColumnController extends AbstractController<ProjectColumnService> {

    @Autowired
    public ProjectColumnController(ProjectColumnService service) {
        super(service);
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String columnPage() {
        return "column/create";
    }

    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String columnCreate(@ModelAttribute ProjectColumnCreateDto dto, @PathVariable(name = "id") Long id, HttpServletRequest request) {
        dto.setProject_id(id);
        service.create(dto);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "delete/{column_id}" , method = RequestMethod.GET)
    public String delete(@PathVariable(name = "column_id") Long id , HttpServletRequest request){
        service.delete(id);
        return "redirect:"+request.getHeader("Referer");
    }
}
