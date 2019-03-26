package lab2_1;

import org.junit.*;
import edu.iis.mto.bsearch.SearchResult;
import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test {

    private int seq[] = new int[5];
    private int singleEl[] = new int[1];

    @Before
    public void initTest() {
        for (int i = 0; i < 5; i++) {
            seq[i] = i + 1;
        }
        singleEl[0] = 1;
    }

    @org.junit.Test
    public void elementFoundSeqLen1() {
        SearchResult result = search(singleEl[0], singleEl);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @org.junit.Test
    public void elementNotFoundSeqLen1() {
        SearchResult result = search(2, singleEl);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test
    public void elementFoundFirstSeqLen5() {
        SearchResult result = search(seq[0], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @org.junit.Test
    public void elementFoundLastSeqLen5() {
        SearchResult result = search(seq[seq.length - 1], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq.length));
    }

    @org.junit.Test
    public void elementFoundMiddleSeqLen5() {
        SearchResult result = search(seq[seq.length / 2], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq[seq.length / 2]));
    }

    @org.junit.Test
    public void elementNotFoundSeqLen5() {
        SearchResult result = search(-1, seq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

}
