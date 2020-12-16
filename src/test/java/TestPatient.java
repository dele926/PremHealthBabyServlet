import org.junit.Assert;
import org.junit.Test;
public class TestPatient {
    @Test
    public void testNameAssignment(){
        Patient p1,p2;
        p1=new Patient("Martin Holloway");
        p2=new Patient("Geoffrey Chaucer");
        Assert.assertEquals(p1.getName(),"Martin Holloway");
        Assert.assertEquals(p2.getName(),"Geoffrey Chaucer");
    }
    @Test
    public void testAddingNotes(){
        Patient p=new Patient("Martin Holloway");
        String notesShouldBe=new String();
        for(int i=0;i<10;i++) {
            String note="Note "+i;
            p.addNote(note);
            notesShouldBe+=note+"\n";
        }
        Assert.assertEquals(notesShouldBe,p.getNotes());
    }
    @Test
    public void testAutoIncrementingIDGeneration(){
        Patient p=new Patient("Martin Holloway");
        int firstID=p.getId();
        for(int i=firstID;i<=30;i++){
            Assert.assertEquals(i,p.getId());
            p=new Patient("Martin Holloway");
        }
    }
}