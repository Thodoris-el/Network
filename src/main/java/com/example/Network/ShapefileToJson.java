package com.example.Network;
// shp2csv conversion
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.feature.simple.SimpleFeature;

public class ShapefileToJson
{


    private static SimpleFeatureIterator simpleFeatureIterator;
    static FileDataStore store ;
    static String ID="";



    public  static boolean openShapeFile(File srcfname) throws Exception



    {
        String filename=srcfname.getAbsolutePath();
        File dataFile = new File(filename);
        dataFile.setReadOnly();
        store = FileDataStoreFinder.getDataStore(dataFile);
        // ShapefileDataStore store = new ShapefileDataStore(dataFile.toURL());

        SimpleFeatureSource source = store.getFeatureSource();
        SimpleFeatureCollection featureCollection = source.getFeatures();
        simpleFeatureIterator = featureCollection.features();
        return true;
    }
    public  static boolean iterate(File srcfname, String dest_path)
    {
        File dest_file=srcfname;

        String dest_filename=ShapefileToJson.getFileNameWithoutExtension(dest_file)+".csv";

        try{
            BufferedWriter  bw=new BufferedWriter (new FileWriter(dest_path+dest_filename));

            bw.write("ID"+","+ "date"+","+"tstamp"+","+"X_prj"+","+"Y_prj"+","+"NEAR_FID"+","+"NEAR_DIST");
            while(simpleFeatureIterator.hasNext())
            {

                SimpleFeature f = simpleFeatureIterator.next();

                //  System.out.println(""+f.getID()+" ,"+f.getAttribute(1)+", "+f.getAttribute(2)); //ID, field 1: lat, field 2: long

                //writing in a CSV file
                bw.write("\n");

                int index = f.getID().lastIndexOf('.');
                ID=f.getID().substring(index+1); //get only the ID //by default ID comes with filename.ID format when getID() method called
                bw.write(Integer.parseInt(ID)+" ,"+f.getAttribute(1).toString()+", "+f.getAttribute(2)+","+f.getAttribute(3)+","+f.getAttribute(4)+","+f.getAttribute(5)+","+f.getAttribute(6));

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();

        }
        finally{
            simpleFeatureIterator.close();
            store.dispose();
        }

        return true;
    }

    public static String getFileNameWithoutExtension(File f)
    {
        String s="";
        int index = f.getName().lastIndexOf('.');
        //System.out.println (index);
        if (index>0&& index <= f.getName().length() - 2 )
        {
            s= f.getName().substring(0, index);
        }
        return s;
    }
    public static void main(String[] args) {
        try {

            String dest_path="C:\\ArcGIS test data\\commonfiles csv\\001\\nr_train\\";

            File src_dir= new File ("C:\\ArcGIS test data\\commonfiles prj\\001\\nearTrain");

            File [] file_nr = src_dir.listFiles();  //array containing files from nearRoad
            for (int i=0; i<file_nr.length; i++)  //near road
            {
                if (file_nr[i].getName().endsWith(".shp"))
                {
                    ShapefileToJson.openShapeFile(file_nr[i]);
                    ShapefileToJson.iterate(file_nr[i], dest_path );
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}