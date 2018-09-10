package dip01.encapsulate.collection.before;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class DemoTest
{
	private Person kent;
	private Set<Course> s;
	
	private Course course1 = new Course("Smalltalk Programming", false);
	private Course course2 = new Course("Refactoring", true);
	private Course course3 = new Course("Appreciating Single Malts", true);
	
	@Before
	public void setup() throws Exception
	{
		kent = new Person();
		s = new HashSet<>();
		kent.setCourses(s);

		s.add(course1);
		kent.getCourses().add(course2);
	}

	@Test
	public void should_increment_count_by_one_when_new_course_added() throws Exception
	{

		s.add(course3);
		kent.getCourses().add(new Course("Brutal Sarcasm", false));
		
		assertEquals (4, kent.getCourses().size());
	}
	
	@Test
	public void should_decrement_count_by_one_when_new_course_added() throws Exception
	{	
		kent.getCourses().remove(course2);
		
		assertEquals(1, kent.getCourses().size());
	}
	
	@Test
	public void should_be_able_to_count_number_of_advanced_courses() throws Exception
	{
		int count = 0;
		for (Course course : kent.getCourses()) {
			if (course.isAdvanced())
				count++;
		}
		
		assertEquals(2, count);
	}
}
