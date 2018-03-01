import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import reversed_list.ReversedList;

public class ReversedListTests {

    private ReversedList<Integer> integerReversedList;

    @Before
    public void createList() {
        this.integerReversedList = new ReversedList<>();
    }

    @Test
    public void addElementShouldIncreaseCount() {
        for (int i = 0; i < 10; i++) {
            this.integerReversedList.add(i);
        }

        Assert.assertEquals(10, this.integerReversedList.size());
    }

    @Test
    public void removeElementShouldDecreaseCount() {
        for (int i = 0; i < 10; i++) {
            this.integerReversedList.add(i);
        }

        for (int i = 0; i < 5; i++) {
            this.integerReversedList.removeAt(i);
        }

        Assert.assertEquals(5, this.integerReversedList.size());
    }

    @Test
    public void getElementShouldReturnCorrectValue() {
        for (int i = 0; i < 10; i++) {
            this.integerReversedList.add(i);
        }

        for (int i = 9, j = 0; i >= 0; i--, j++) {
            int currElement = this.integerReversedList.get(j);
            Assert.assertEquals(i, currElement);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getElementShouldThrowExceptionWhenInvalidIndexGiven() {
        for (int i = 0; i < 5; i++) {
            this.integerReversedList.add(i);
        }

        this.integerReversedList.get(5);
    }

    @Test
    public void setElementShouldReplaceElementAtGivenPosition() {
        for (int i = 0; i < 5; i++) {
            this.integerReversedList.add(i);
        }

        this.integerReversedList.set(2, 3);
        int result = this.integerReversedList.get(2);
        Assert.assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setElementShouldThrowExceptionWhenInvalidIndexGiven() {
        this.integerReversedList.set(1, 100);
    }

    @Test
    public void removeAtShouldReturnCorrectValueAndDecreaseListSize() {
        for (int i = 0; i < 10; i++) {
            this.integerReversedList.add(i);
        }

        int result = this.integerReversedList.removeAt(2);
        Assert.assertEquals(7, result);

        Assert.assertEquals(9, this.integerReversedList.size());
    }


}
