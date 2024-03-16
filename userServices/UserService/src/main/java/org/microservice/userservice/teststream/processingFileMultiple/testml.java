package org.microservice.userservice.teststream.processingFileMultiple;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

public class testml {
    public static void main(String[] args) {

    /** I have an array containing 'n' elements.
     - I want you to write an wrapper class that implement Supplier around an array.
     - On invocation of get, it should return the items in the array in sequence, starting from 0
     - At the end of the array, it should return the first item when asked for the item.
     - Additionally, add a limiter count 'L' such that when provided, it will only loop the array 'L' times*/


     /*   File processing
        1. Client will dump one or more files in a shared directory
        2. Each file has the following format:
        - Each line in the file should be considered as an instruction that should be read in the form of a string
        - Each line will terminate with a LF (\n)
        - Each line when processing may result in some error
        3. Client has provided us with a proprietary custom library that is capable of processing each line passed in.
        - The library API has the following class that should be invoked
        -- boolean com.acme.ai.DataProcessor#parse(String)
                - Each invocation of the parse method takes around 1 second to complete
        4. The client would like you to process the files at the fastest speed possible and provide the logs as output
        Logformat: fileName - true: <count>; false: <count>; failed: <count>
*/






    }
}
