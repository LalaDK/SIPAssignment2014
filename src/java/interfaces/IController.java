/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import entities.Subject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Thomas
 */
public interface IController {
        public ArrayList<Subject> getSubjectsForRound(int round);
        public HashMap getSatisfaction();
}
