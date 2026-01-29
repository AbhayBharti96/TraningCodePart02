package PracticeQuestionScenarioBased;

import java.util.*;
import java.util.stream.Collectors;

class Trail {
	private String id;
	private String name;
	private String region;
	private String difficulty;
	private int hikeCount;

	Trail(String id, String name, String region, String difficulty, int hikeCount) {
		this.id = id;
		this.name = name;
		this.region = region;
		this.difficulty = difficulty;
		this.hikeCount = hikeCount;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRegion() {
		return region;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public int getHikeCount() {
		return hikeCount;
	}

	public void setHikeCount(int hikeCount) {
		this.hikeCount = hikeCount;
	}

	@Override
	public String toString() {
		return id + " | " + name + " | " + region + " | " + difficulty + " | " + hikeCount + " hikes";
	}
}

public class TrailUtil {

	/* Requirement 1 */
	public static void addTrailRecord(ArrayList<Trail> list, Scanner s) {
		System.out.println("Enter number of trails:");
		int n = s.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter id, name, region, difficulty, hikeCount:");
			String id = s.next();
			String name = s.next();
			String region = s.next();
			String difficulty = s.next();
			int hikeCount = s.nextInt();

			list.add(new Trail(id, name, region, difficulty, hikeCount));
		}
	}

	/* Requirement 2 */
	public static Trail getTrailById(String trailId, List<Trail> list) {
		for (Trail t : list) {
			if (t.getId().equals(trailId)) {
				return t;
			}
		}
		return null;
	}

	/* Requirement 3 */
	public static Set<Trail> getMostHikedTrails(List<Trail> list) {
		int max = list.stream()
				.mapToInt(Trail::getHikeCount)
				.max()
				.orElse(0);

		return list.stream()
				.filter(t -> t.getHikeCount() == max)
				.collect(Collectors.toSet());
	}

	/* Requirement 4 */
	public static Map<String, Integer> getHikeCountByRegion(List<Trail> list) {
		return list.stream()
				.collect(Collectors.groupingBy(
						Trail::getRegion,
						Collectors.summingInt(Trail::getHikeCount)
				));
	}

	/* Requirement 5 */
	public static Map<String, List<Trail>> groupTrailsByDifficulty(List<Trail> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Trail::getDifficulty));
	}

	/* Requirement 6 */
	public static boolean updateHikeCount(String trailId, int additionalHikes, List<Trail> list) {
		for (Trail t : list) {
			if (t.getId().equals(trailId)) {
				t.setHikeCount(t.getHikeCount() + additionalHikes);
				return true;
			}
		}
		return false;
	}

	/* Requirement 7 */
	public static List<Trail> filterTrails(String region, String difficulty, List<Trail> list) {
		return list.stream()
				.filter(t -> t.getRegion().equals(region)
						&& t.getDifficulty().equals(difficulty))
				.collect(Collectors.toList());
	}

	/* Requirement 8 */
	public static Map<String, List<Trail>> getTopTrailsByRegion(List<Trail> list, int n) {
		return list.stream()
				.collect(Collectors.groupingBy(
						Trail::getRegion,
						Collectors.collectingAndThen(
								Collectors.toList(),
								l -> l.stream()
										.sorted(Comparator.comparingInt(Trail::getHikeCount).reversed())
										.limit(n)
										.collect(Collectors.toList())
						)
				));
	}

	/* Requirement 9 */
	public static Map<String, String> getDifficultyStats(List<Trail> list) {
		Map<String, List<Trail>> map = groupTrailsByDifficulty(list);
		Map<String, String> result = new LinkedHashMap<>();

		for (Map.Entry<String, List<Trail>> e : map.entrySet()) {
			int count = e.getValue().size();
			int total = e.getValue().stream().mapToInt(Trail::getHikeCount).sum();
			int avg = total / count;

			result.put(e.getKey(),
					"count=" + count + ", totalHikes=" + total + ", averageHikes=" + avg);
		}
		return result;
	}

	/* ================= MAIN ================= */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Trail> trails = new ArrayList<>();

		addTrailRecord(trails, s);

		System.out.println("Enter the Trail Id to check hike status");
		String id = s.next();
		Trail t = getTrailById(id, trails);
		System.out.println(t != null ? t : "Trail Id " + id + " not found");

		System.out.println("Most hiked trails are");
		getMostHikedTrails(trails).forEach(System.out::println);

		System.out.println("Region-wise hike counts");
		getHikeCountByRegion(trails)
				.forEach((k, v) -> System.out.println(k + ": " + v + " hikes"));

		System.out.println("Trails grouped by difficulty");
		groupTrailsByDifficulty(trails).forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});

		System.out.println("Enter Trail Id to update hikes and additional hikes");
		String tid = s.next();
		int add = s.nextInt();
		if (updateHikeCount(tid, add, trails)) {
			System.out.println("Updated " + tid + " by " + add + " hikes");
			System.out.println(getTrailById(tid, trails));
		}

		System.out.println("Filter trails by region and difficulty");
		String region = s.next();
		String diff = s.next();
		filterTrails(region, diff, trails).forEach(System.out::println);

		System.out.println("Enter N for top trails per region");
		int n = s.nextInt();
		getTopTrailsByRegion(trails, n).forEach((k, v) -> {
			System.out.println(k);
			v.forEach(System.out::println);
		});

		System.out.println("Difficulty statistics");
		getDifficultyStats(trails)
				.forEach((k, v) -> System.out.println(k + ": " + v));
	}
}
