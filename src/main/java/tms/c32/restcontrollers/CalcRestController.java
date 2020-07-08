package tms.c32.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tms.c32.resources.CalcResource;
import tms.c32.entity.Operation;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalcRestController {

    @Autowired
 private List<Operation>operationList;
    @Autowired
    CalcResource calc;

    @PostMapping
    public ResponseEntity<String> calc(HttpSession httpSession, @RequestBody Operation operation) {
            return new ResponseEntity<>("Result= " + calc.calculator(operation.getNum1(), operation.getNum2(), operation.getOperation()), HttpStatus.BAD_REQUEST);
        }




    @GetMapping
    public ResponseEntity<List<Operation>> calc() {
        return new ResponseEntity<>(operationList, HttpStatus.OK);
    }
}
