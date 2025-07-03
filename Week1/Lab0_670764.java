import java.util.List;
import java.util.ArrayList;
import java.util.Array;
import java.util.Collections;

public class Lab0_670764 {
	public static void main(String[] args) {
		demo_1();
	}

	static void mergeBeams(List<int[]> beams) {

		// step 1: linearized
		int i = 0;
		for (int[] beam : beams) {
			if (beam[i] > beam[i+1])
				beam[i+1] += 360;
		}

		// step 2: sort
		Collections.sort(beams , (a, b -> a[0] - b[0]);

		// step 3: Merge overlapping intervals
		int k;
		for (int j = 0; j < beams.size(); j++) {
			k = 1;
			if (beams[j][k] 		
		}
	}

	static void demo_1() {
		int n = 3;
		int [] data = {10, 90, 70, 100, 150, 210};
		List<int[]> beams = new ArrayList<>();
		for (int i = 0; i < 2*n; i+=2) {
			beams.add(new int[] {data[i], data[i+1]});
		}
		List<int[]> merged = mergeBeams(beams);

		for (int[] beam : merged) {
			System.out.println(Arrays.toString(beam));
		}
	}
}

/*
beams.get(0); --> {70, 100}
{{70, 100}, {150, 180}, {160, 185}, {350, 60}}
*/
