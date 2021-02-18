package gr.hua.dit.springmvc1.dao;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Classes;
import gr.hua.dit.springmvc1.entity.semester_classes;

//Create Interface with a method that returns a list of classes
public interface classesDAO {

	public List<Classes> getClasses(String name); 

}
