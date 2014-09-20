/**
 * 
 */
package bugbusters.bots.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author User1
 *
 */
public class World {

	private Set<GameObject> friends = new HashSet<GameObject>();
	private Set<GameObject> enemies = new HashSet<GameObject>();
	private Set<GameObject> mines = new HashSet<GameObject>();
	private Set<GameObject> cookies = new HashSet<GameObject>();
	private Set<GameObject> bullits = new HashSet<GameObject>();

	public Set<GameObject> getFriends() {
		return friends;
	}

	public Set<GameObject> getEnemies() {
		return enemies;
	}

	public Set<GameObject> getMines() {
		return mines;
	}

	public Set<GameObject> getCookies() {
		return cookies;
	}

	public Set<GameObject> getBullits() {
		return bullits;
	}
}
