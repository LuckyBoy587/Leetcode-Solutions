import java.util.*;

public class ImplementRouter3508 {
    public static void main(String[] args) {
        Router router = new Router(3);
        System.out.println(router.addPacket(1, 4, 90));  // true
        System.out.println(router.addPacket(2, 5, 90));  // true
        System.out.println(router.addPacket(1, 4, 90));  // false
        System.out.println(router.addPacket(3, 5, 95));  // true
        System.out.println(router.addPacket(4, 5, 105)); // true
        System.out.println(Arrays.toString(router.forwardPacket())); // [2, 5, 90]
        System.out.println(router.addPacket(5, 2, 110)); // true
        System.out.println(router.getCount(5, 100, 110)); // 1
    }

    private static class Router {
        private static final int[] EMPTY_PACKET = new int[]{};
        Queue<String> packetQueue = new LinkedList<>();
        Map<String, int[]> keyToPacketMap = new HashMap<>();
        Map<Integer, List<Integer>> destinationToTimestamps = new HashMap<>();
        int memoryLimit;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            String key = makeKey(source, destination, timestamp);
            if (keyToPacketMap.containsKey(key)) return false;
            packetQueue.add(key);
            int[] packet = new int[]{source, destination, timestamp};
            keyToPacketMap.put(key, packet);
            destinationToTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
            if (packetQueue.size() > memoryLimit) {
                String keyToRemove = packetQueue.poll();
                int[] packetToRemove = keyToPacketMap.get(keyToRemove);
                destinationToTimestamps.get(packetToRemove[1]).remove(Integer.valueOf(packetToRemove[2]));
                keyToPacketMap.remove(keyToRemove);
            }
            return true;
        }

        public int[] forwardPacket() {
            if (packetQueue.isEmpty()) return EMPTY_PACKET;
            String key = packetQueue.poll();
            int[] packet = keyToPacketMap.get(key);
            keyToPacketMap.remove(key);
            destinationToTimestamps.get(packet[1]).remove(Integer.valueOf(packet[2]));
            return packet;
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> timeStamps = destinationToTimestamps.get(destination);
            if (timeStamps == null || timeStamps.isEmpty()) return 0;

            int left = startIndex(startTime, timeStamps);
            int right = endIndex(endTime, timeStamps);

            if (left > right) return 0; // no valid timestamps
            return right - left + 1;    // inclusive count
        }

        private int startIndex(int time, List<Integer> timeStamps) {
            int left = 0, right = timeStamps.size() - 1;
            int res = timeStamps.size();
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (timeStamps.get(mid) >= time) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        private int endIndex(int time, List<Integer> timeStamps) {
            int left = 0, right = timeStamps.size() - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (timeStamps.get(mid) <= time) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }

        private String makeKey(int source, int destination, int timeStamp) {
            return source + "-" + destination + "-" + timeStamp;
        }
    }
}
