/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author Kaustubh
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
