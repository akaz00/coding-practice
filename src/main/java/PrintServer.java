import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * You are writing a simulation for a print server. This print server can accept
 * jobs from 3 sources – network, USB or operator. It can dispatch only one job
 * at a time. Each input job should contain an integer t which is the time in
 * seconds it will take to process the job. Write a multi-threaded program to
 * simulate the server and provide some simulated load with jobs. Think of some
 * interesting statistics your program should emit and code them in.
 */
public class PrintServer {
	static enum Source {
		NETWORK, USB, OPERATOR
	}

	static class Job {
		int t;
		Source source;

		Job(Source source, int t) {
			this.source = source;
			this.t = t;
		}
	}

	private ScheduledExecutorService service = Executors
			.newScheduledThreadPool(1);

	public PrintServer submit(final Job job) {
		service.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println(job.source);
			}

		}, job.t, TimeUnit.SECONDS);
		return this;
	}

	public static void main(String args[]) throws Exception {
		new PrintServer().submit(new Job(Source.NETWORK, 10)).submit(new Job(Source.USB, 4)).submit(new Job(Source.OPERATOR, 5));
	}
}
