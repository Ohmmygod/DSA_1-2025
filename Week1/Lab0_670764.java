import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lab0_670764 {
	public static void main(String[] args) {
		demo_1();
	}

	static List<int []> mergeBeams(List<int[]> beams) {

		for (int [] beam : beams) {
			if (beam[0] > beam[1])
				beam[1] += 360;
		}

		Collections.sort(beams, (a, b) -> a[0] - b[0]);

		List<int []> merged = new ArrayList<>();
		int start = -1;
		int end = -1;

		for (int [] beam : beams) {
			if (start == -1)
			{
				start = beam[0];
				end = beam[1];
			}
			else if (beam[0] <= end)
				end = Math.max(end, beam[1]);
			else
			{
				merged.add(new int[]{start % 360, end % 360});
				start = beam[0];
				end = beam[1];
			}
		}
		merged.add(new int[]{start % 360, end % 360});
		return merged;
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
