package com.san.mobile.photo.mobile.bean;

import com.san.mobile.photo.mobile.util.RestCallerUtil;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import oracle.adf.model.datacontrols.device.DeviceManager;
import oracle.adf.model.datacontrols.device.DeviceManagerFactory;
import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.util.logging.Trace;
public class PhotoBean {
    public void submitPhoto(ActionEvent actionEvent) {
        try {
            String restURI = "/photos/postImage";
            RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
            restServiceAdapter.clearRequestProperties();
            restServiceAdapter.setConnectionName("REST-Konnect");
            restServiceAdapter.setRequestType(RestServiceAdapter.REQUEST_TYPE_POST);
            restServiceAdapter.addRequestProperty("Content-Type", "application/json");
            restServiceAdapter.addRequestProperty("Accept", "text/plain; charset=UTF-8");
            DeviceManager dm = DeviceManagerFactory.getDeviceManager();
            String imageDataB64 = dm.getPicture(50, DeviceManager.CAMERA_DESTINATIONTYPE_DATA_URL, 
                                                    DeviceManager.CAMERA_SOURCETYPE_CAMERA,
                                                    false, DeviceManager.CAMERA_ENCODINGTYPE_JPEG, 0, 0);
            imageDataB64 = URLEncoder.encode(imageDataB64, java.nio.charset.StandardCharsets.UTF_8.toString());
            if(imageDataB64 != null){
                imageDataB64 = "imageData={\"imageDataB64\": \"" + imageDataB64 + "\"}";
            }
            restServiceAdapter.setRequestURI(restURI);        
            restServiceAdapter.setRetryLimit(0);  
            String response = restServiceAdapter.send(imageDataB64);
            } catch (Exception e) {
                Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", "Invoke of REST Resource failed for "+RestServiceAdapter.REQUEST_TYPE_POST+" to ");
                Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", e.getLocalizedMessage());
            }
    }
    
 
    
    public void submitPhoto2(ActionEvent actionEvent) {
        // Add event code here...
         String restURI = "/employees/postImage";
        RestCallerUtil rcu = new RestCallerUtil();
        String aTE = rcu.invokeCREATE(restURI, "payload");
        
        String restPayload = "";
        
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        restServiceAdapter.setConnectionName("REST-Konnect");
        
        //set GET, POST, DELETE, PUT
        restServiceAdapter.setRequestType(RestServiceAdapter.REQUEST_TYPE_POST);
        
        //this sample uses JSON only. Thus the media type can be hard-coded in this class
        //the content-type tells the server what format the incoming payload has
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        //the accept header indicates the expected payload fromat to the server
        restServiceAdapter.addRequestProperty("Accept", "text/plain; charset=UTF-8");
        DeviceManager dm = DeviceManagerFactory.getDeviceManager();
        //String imageDataB64 = dm.getPicture(50, DeviceManager.CAMERA_DESTINATIONTYPE_DATA_URL, DeviceManager.CAMERA_SOURCETYPE_CAMERA,
         //             false, DeviceManager.CAMERA_ENCODINGTYPE_JPEG, 0, 0);
        String imageDataB64 = "%2F9j%2F4AAQSkZJRgABAgAAAQABAAD%2F2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL%2F2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL%2FwAARCADgAOcDASIAAhEBAxEB%2F8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL%2F8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4%2BTl5ufo6erx8vP09fb3%2BPn6%2F8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL%2F8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3%2BPn6%2F9oADAMBAAIRAxEAPwD3%2BiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiq99f2emWcl5f3cFpax43zTyCNFyQBljwMkgfjQBYqnqWrabo1utxqmoWljAzhFkupliUtgnALEDOATj2NeF%2BMv2if9bZeELP1T%2B0Ltf8AeGY4%2FwDvlgX9wUrA0r4T%2BPfiJqJ1fxTeT2Eb5HnagC02MudqQ5GxQ38J2ABsqCKAPR9Z%2FaD8HafvTTlvtUk8oujQw%2BVGX5wjGTDDoMkKcA9zxXCal%2B0nr0twraXoem20GwBkumedi2TyGUoAMY4x2PPPHofh34DeDtF8uW%2Bin1e6Xy2LXb4jDrySI1wCpP8AC5fgAeufRNN0nTdGt2t9L0%2B0sYGcu0drCsSlsAZIUAZwAM%2BwoA%2BaIfiL8ZdZQ6hpkOpSWc7s0RtNGWSIDcRtVvLYkAgjkk8cnNSf8Jl8c%2F8An11z%2FwAES%2F8Axmvp%2BigD5g%2F4Xv8AEDQf%2BJbq2n2LX0P%2BsN%2FZSRTc%2FMNyqyAcEYwo4x1611%2BmftKaPL5v9reH761xjy%2FskyXG7rnO7Zjt0znJ6Y59wrj9T%2BFfgbV%2FK%2B0%2BGbGPys7fsim2znGc%2BUV3dO%2Bcc46mgC5oHj%2Fwp4odYtH1y0nnZyiwMTFK5C7jtjcBiMc5AxwfQ10lfPHif9nC4gimufDGrfadvKWd6oVyAvIEo%2BUsWHAKqOeTxk4%2BlfFjx78O9ROkeKbOe%2FjTJ8nUCVmxlxuSbB3qW%2FiO8ELhSBQB9P0Vy%2Fg74geH%2FHFn5uk3W24XcZLKcqs8YBA3FATleV%2BYEjnGc5A6igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKx%2FE%2FifS%2FCOhzavq8%2FlW8fCqvLyueiIO7HB%2FIkkAEgAPE%2FifS%2FCOhzavq8%2FlW8fCqvLyueiIO7HB%2FIkkAEj5ovtT8c%2FHHXJLOzhxptvKJVtgwSC0VsKGd8Au2Mnu339qgZFSWEGr%2FHb4m%2Fab6KS10yFAsz26gi0twWKJuONzsxIycnJYhdq4H0n4Y8MaX4R0OHSNIg8q3j5Zm5eVz1dz3Y4H5AAAAAAHP%2BBfhZ4f8AAsQlt4vtupnBa%2FuUUup27SIxj92py3AJJ3YJOBjuKKKACiiigAooooAKKKKACs%2FWdD0vxDpz2Gr2EF7atk7JkztJBG5T1VsE4YYIzwa0KKAPmjxj8Jdd%2BHV5%2FwAJV4Pv55rOw2y7iQbm34IdmAUK8frx0YgqVBau%2FwDhZ8YbPxVZx6Vr9zBaa7HtRXdhGl7khQV7CQkgFB1zleMhfWK%2BfPi78GrHTtLvfFHhtZIhE%2FnXenqu5FQ4BaIAZUKcsQeACSCoUAgH0HRXk%2Fwe%2BKdv4q0630DVZfL121iCI0jk%2FbUUffBJyZABlgTzyw4yF9YoAKKKKACiiigAooooAKKKKACiiigAooooAK%2BWPG%2FifVPjB8QLbw5oE%2B7ShLtso5P3SOQpLzyZ5OAHI4yF4ChiQfV%2Fjp4u%2FwCEc8DPptu2L7Wd1snH3YQB5rcqQeCExkH95kfdrP8AgD4N%2FsXwvJ4hvIdt9qv%2Bp3rho7cH5cZUEbzluCQyiM0AeieEfC9j4O8NWmj2EcYESAzSqm0zy4G6RuSckjpk4GAOAK3KK5vX%2FH%2FhTwu7RaxrlpBOrhGgUmWVCV3DdGgLAY5yRjkeooA6SiuHsfjB4B1C8jtYfEcCSPnBnikhQYBPLuoUdO556da7SCeG6t4ri3ljmglQPHJGwZXUjIII4II5zQBJRRRQAUUUUAFFFFABRRRQAUUUUAfMnxh8DN4D8S2Pizw5FHaWElwjoqFSLe7UlxtQjAQhdwHIBDDgbRXufw%2F8Y2%2FjjwlbatF8twuIbyMIVEc4UFwuScryCOTwRnnIGxrmjWfiHQ73SL9N9rdxNE%2BACVz0ZcggMDgg44IBr5w%2BE%2Bq3nw7%2BKt14W1ceXHeyixmwpx5wJ8mRcruKtuIHQEShjwKAPp%2BiiigAooooAKKKKACiiigAooooAKKKz9d1P%2BxPD2p6t5PnfYbSW58rdt37ELbc4OM4xnBoA%2BaPGPm%2FEj4%2Ff2Ovntax3a6ftGyN44YiTOVPQ4ImcE5JyBjotfUcEENrbxW9vFHDBEgSOONQqooGAABwABxivnT9mvTPN8Q65q3nY%2BzWiW3lbfvea%2B7dnPGPJxjHO7tjn3fxZfXGmeDdcv7OTy7q10%2B4mhfaDtdY2KnB4OCB1oA8U%2BLPxZ1K71l%2FCPhF7uGSK48i5ubcMs80wbHlRY%2BYANwSOWPA%2BX78fhj9nC4nihufE%2BrfZt3L2dkoZwCvAMp%2BUMGPICsOODzkV%2F2btGs7vXNa1eZN91YRRRW%2BQCE83fuYZGQ2EwCCOGYc5r6PoA8T1L9mzQZbdV0vXNStp94LPdKk6lcHgKoQg5xznseOePPIbnxr8CvFFvBdN5%2BnzZkMCSsbS7UhQ%2B0kDbIMKN2NwwMgqcN9X1x%2FxS0az1v4a67FeJn7NaSXkLgDckkSl1IJBxnBU452swyM0AbnhzX7HxT4fs9a01pDaXSFk8xdrKQSrKR6hgRxkccEjmtSvB%2F2aL64k07xFYNJm1hlgmjTaPldw4Y568iNPy9zXvFABWXr%2FiPSPC2ltqWtX0dpaBwm9gWLMegVVBLHqcAHgE9Aa1K%2BXPH11ffFD40x%2BG7R5Ire1uG0%2BIN%2FyzCEmeXaXwT8rnggsqIOtAGp4i%2FaP1S58yHw9pMFlGfMQXF23myEHhHCjCow64O8Zx1A5z%2F%2BEy%2BOf%2FPrrn%2FgiX%2F4zXvfhTwH4c8GW4TRtOjjnKbZLuT555OFzlzyASoO0YXPIArpKAPnTRP2k9SS4269odpNAzoN9gzRNGufmO1ywc4xgZXp154930DxHpHinS11LRb6O7tC5TeoKlWHUMrAFT0OCBwQehFZ%2FivwH4c8Z25TWdOjknCbY7uP5J4%2BGxhxyQCxO05XPJBrwDwDdX3wv%2BNMnhu7eSW3urhdPlC%2F8tA5Bgl2h8A%2FMh5JKq7jrQB9R0UUUAFfPH7R%2FhhILzTPE9tBt%2B0ZtLtxtALgZjJH3ixUOCeeEUccZ%2Bh64%2F4qaZ%2Fa%2FwAL%2FENt53lbLQ3O7buz5JEu3GR12Yz2znnpQBc8Aa%2B3ijwHo2sStI089uFnd1VS8qEpI2F4ALKxGMcEcDpXSV4P%2BzXrO%2FTtc0N3gXypUvIkziR942OcZ5UbI%2Bg4LcnkV7xQAUUUUAFFFFABRRRQAUUUUAFeb%2FHW%2Bt7T4UalDPJsku5YIYBtJ3uJFkI46fKjHn09cV6RXj%2F7R3%2FJPNP%2FAOwrH%2F6KloAsfs82NxafDWSaePZHd6hLNAdwO9AqRk8dPmRhz6emK9Qv7G31PTrmwvI%2FMtbqJ4Zk3EbkYEMMjkZBPSuH%2BCX%2FACSHQv8At4%2F9KJK9AoA%2BUNB1bVPgf8Sryz1G2nnsJP3Uq%2Fc%2B0QbvknjG7aWGDgEnGXXIOSPp%2FRtc0vxDpyX%2BkX8F7atgb4XztJAO1h1VsEZU4IzyKy%2FGfgbRfHWlpY6xFIDE%2B%2BG4gIWWE8Z2kgjBAwQQQeD1AI8I1L4E%2BN%2FDV%2Bt94Y1GO9eNwsMtrObS4UFDuY7iAo6rw5JBHHJwAfTdeB%2FGf4t2M%2BlzeFvDl1HdG5QC8vreXKKhwfLRlOGLDhjyACV5JO3nP%2BFbfGLXv%2BJbq15fLYzf6w3%2BsebDx8w3KruTyBjCnnHTrXo%2Fw%2F8AgdpfhS8ttX1a5%2FtPVocPGoXEED4HKg8syndhjjqDtBANAFz4JeCZvCXg5rrULeSDVNUcSzxyAq0Ua5EaEZIzgs3QEb8EfLXYeJfGGgeD7eCfXtSjs0ncpECjOzkDJwqgnA4ycYGR6ityvlz4rX9z8Q%2Fi9B4d0cySC1cadECzlBLuJlkK7cqFPDEA8RZyRjAB9PwTw3VvFcW8sc0EqB45I2DK6kZBBHBBHOa%2BXPEr3Hww%2BPza1cJ59vLdtfqQoJeCcsJNq7vvLukUZIyVBIwa%2Bn7Cxt9M062sLOPy7W1iSGFNxO1FACjJ5OAB1rD8Z%2BBtF8daWljrEUgMT74biAhZYTxnaSCMEDBBBB4PUAgA1NG1zS%2FEOnJf6RfwXtq2BvhfO0kA7WHVWwRlTgjPIrQr5c1D4OfEPwZcTX3h27kuU2SAzaXctDP5QIIDJlSS2AdiF%2BVxzxmT%2FhMvjn%2Fz665%2F4Il%2F%2BM0AfR%2Bs65pfh7Tnv9Xv4LK1XI3zPjcQCdqjqzYBwoyTjgV80eGnuPif8fl1q3TyLeK7W%2FYlQCkEBUR7l3febbGpwTgsSBgVJp%2Fwc%2BIfjO4hvvEV3JbJsjAm1S5aafyiSSFTLEFck7HKctjjnHv%2FAIM8DaL4F0t7HR4pCZX3zXE5DSzHnG4gAYAOAAAByepJIB0lFFFABRRRQB8wfAj%2FAIkPxavtJ1L9xfNaXFkIvvfvkdWZcrkcCNznOOOvIr6fr5g8G%2F8AJ0Nz%2FwBhXUv%2FAEGavp%2BgAooooAKKKKACiiigAooooAK8j%2FaKgmm%2BHNq8UUjpDqcTysqkhF8uRct6DcyjJ7kDvXrlcX8WtNm1X4V%2BILeBo1dLcXBLkgbYnWVhwDztQge%2BOnWgDP8AgdPDN8JNISKWN3hedJVVgSjec7Yb0O1lOD2IPevRK8T%2FAGbNShl8K6zparJ59vei4diBtKyIFUDnOcxNnjuOvb2ygAooooAKKKKAOX%2BIfidPCPgbU9U8%2FwAm6ERisyNpYzsMJhW4bB%2BYjn5VY4OK8g%2FZw8MJPean4nuYN32fFpaOdpAcjMhA%2B8GClADxw7DnnFf9oPxC%2BseKNM8J6cs80lnh5YYix8yeULsTZj5mC4wRn%2FWkcHOfc%2FB2gL4W8HaVoqrGHtbdVl8tmZWlPzSMC3OC5Y9uvQdKANyiiigAooooAKKKKACiiigAooqnq2pQ6No19qlwsjQWVvJcSLGAWKopYgZIGcD1FAHzZ4B%2F4mH7St1eWX%2Bk2o1DUJzND86CNhKFfcONpLKAeh3D1r6fr5o%2FZusbiTxlq1%2BsebWHT%2FJkfcPld5EKjHXkRv8Al7ivpegAooooAKKKKACiiigAooooAKjnghureW3uIo5oJUKSRyKGV1IwQQeCCOMVJRQB8wfBi%2F8A%2BEO%2BLV%2F4e1K72%2Bf5unny5MQtcRv8pO7Gc7XVTjOXAx8xr6fr5s%2BO2hX3hvx5YeNNPeQC6eNxKV3CG5hC7eq7QCqqQCSSVfsK978K%2BIbfxX4X07XLVdkd3EHKZJ8twcOmSBnawYZxzjI4oA2KKKKACs%2FXNZs%2FD2h3ur377LW0iaV8EAtjoq5IBYnAAzySBWhXhf7RvihYNL0%2FwvBJIJ7lxeXO12UeUuVRWGMMGbJ68GIccg0Acp8D9Gl8W%2FEq98R6qn2n7FuvJJCECm6kY7SVx%2F10cbQMMi8jgH6frh%2FhJ4Yfwr8OtPtbmDyb65zd3SndkO%2FQMGxtYIEUjAwVPXqe4oAKKKKACiiigAooooAKKKKACvM%2Fjr4hh0b4b3VkLmSK81R1t4FicKxUMGkJ5B2bQVOM%2FfAPBr0yvmD4sarefET4q2vhbSB5kdlKbGHKnHnEjzpGwu4Ku0A9QBEWHBoA9D%2FZ60BdN8By6wyx%2BfqtwzB1ZifKjJRVYHgEN5p47MMnsPXKp6TpsOjaNY6XbtI0Flbx28bSEFiqKFBOABnA9BVygAooooAKKKKACiiigAooooAKKKKAOb8eeFIfGfg6%2FwBGcRid032sj4%2FdzLyhzgkDPykgZ2swHWvEPgR4zbw74gufBurRyQJe3B8nzdsfkXIG1kcMActtVQM5DKAB8xI%2Bk68H%2BPPw3%2B0xS%2BM9Jhnkul2jUYU%2BYGNVwJhzkbQqggAjHzcbWJAPeKK8r%2BE3xZh8ZW6aPrDxw%2BIIk4OAq3igcso6BwOWUf7w4yF9UoA5%2FwAcXWu2PgvVLnw1b%2Bfq8cWbdAgc9RuKqfvMF3EDnJAGD0PiHgvxv4W8daja2%2FxLtbGXVrPLWeq3BEMcqg7vLmClU4OcBhtIJGAT8%2F0fXj%2FxO%2BCln4k%2B2654fH2bW3%2FePbZCw3Tc7v8Adkbj5s7SRyAWLUAewUV80fDf4y3nhHyvDPiq3nksbeXyFnfImsVGQUZCMsqnHHDKMgbsKo%2Bj7G%2Fs9Ts47ywu4Lu1kzsmgkEiNgkHDDg4II%2FCgCxRXN%2BK%2FHnhzwZbl9Z1GOOcpujtI%2Fnnk4bGEHIBKkbjhc8EivAPFHxJ8X%2FFHVH0HwxZ3cOns7Bbe13CWaJsJm4cHAT5uRwg3%2FMWwDQB7O%2Fxf8If8JjaeG4LyS7nunSNbu1VZLcSP91C4OSSdoyoIBYZIw2O8ryP4c%2FBCx8LXFvrGuyx3%2BsQuzRRxnNvCcjawBUFnGCcnABPAyoavXKACiiigAoorL8R6%2FY%2BFvD95rWpNILS1QM%2FlruZiSFVQPUsQOcDnkgc0Ac38U%2FHSeBfCUlxEc6neboLJQy5Vyp%2FekNnKpwTwckqDjdkeb%2Fs7eDf%2BPvxfew%2BtrYb1%2F7%2BSDK%2FRAyn%2FnoDXIW0Ou%2FHX4lLdT23kafDsScxEBbS1DEhd5B3SHLYyOWJOAoO36nsLG30zTraws4%2FLtbWJIYU3E7UUAKMnk4AHWgCxRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB82fEz4fa14H8WDxh4OgkhsA5nAsYyTYuFy%2B5eR5RAY9NoBKkAY3d%2F8JvizD4yt00fWHjh8QRJwcBVvFA5ZR0Dgcso%2F3hxkL6pXgfxG%2BArXNxcax4OWMPI6s2knaigknc0bkgKOh2HAHzYP3VoA98or5s8GfHfV%2FDrvpPjK1u79IX8vzsBbqDapUo6tjedwGSxDAliS3AHvfh7xVoXiuzN1oepwXsa%2FfCEh48kgbkOGXO04yBnGRxQBh%2BPvhnovj%2B3ja8MlrqECMsF7CBuAIOFcH76BjnHB64Iyc%2BMT%2FBL4h%2BFriW78N6lHM7OYVawvGtp2iJzlt20AfKuVDNzjrjNfTdFAHzx4e%2FZuvGvC3iXWYEtV6R6aSzycH%2BJ1ATB2%2FwALZ5HHWvb%2FAA94V0LwpZm10PTILKNvvlAS8mCSNznLNjccZJxnA4rYooAKKKKACio554bW3luLiWOGCJC8kkjBVRQMkkngADnNeR%2BMvj9oWi%2BbZ%2BHov7XvlyvnZK20bfMM7usmCFOFwrA8PQB6R4n8T6X4R0ObV9Xn8q3j4VV5eVz0RB3Y4P5EkgAkfMmpa143%2BNviBbC1gk%2Fs9LgNHboCLezDAgNLIBydqty3JO4KBnbVjQPA%2FjT4xaouva1fSRWLoY%2F7SnjUg7OAkUSlcjcTyMLnfyWyD9J%2BGPDGl%2BEdDh0jSIPKt4%2BWZuXlc9Xc92OB%2BQAAAAABX8F%2BE7PwV4XtdFs383ysvNOUCNNIxyzED8AM5IUKMnGa6CiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAOb8V%2BA%2FDnjO3Kazp0ck4TbHdx%2FJPHw2MOOSAWJ2nK55INeIa78CfFfhvVE1DwXqMl2A5ERScW11CG3D72QpG3ALAgksflAr6TooA%2BYLD4z%2FEDwd9m03xDp32jbsfGp20kNy0PC4DcZztb52VjnOc9K7PTf2k9Blt2bVND1K2n3kKlqyTqVwOSzFCDnPGOw5549kvrCz1Ozks7%2B0gu7WTG%2BGeMSI2CCMqeDggH8K4%2B%2B%2BD%2FgHULyS6m8OQJI%2BMiCWSFBgAcIjBR07Dnr1oApwfHH4fTW8Ur61JA7oGaKSzmLISPunahGR04JHoTUn%2FAAu34ef9DD%2F5JXH%2FAMbrDn%2FZ18GzXEsqXeswI7llijuIyqAn7o3Rk4HTkk%2BpNR%2F8M4%2BD%2FwDoJa5%2F3%2Fh%2F%2BNUAWL79obwVaXkkEMWq3sa4xPBbqEfIB4DurcdOQOnpzXEan%2B0prEvlf2T4fsbXGfM%2B1zPcbumMbdmO%2FXOcjpjn0ex%2BBXgG0s44JtLnvZFzmee7kDvkk8hGVeOnAHT15rsNG8KeH%2FD2w6RotjZSLEIfOhgUSMgxwz43N0BOSckZPNAHzZB4V%2BKnxTEV1qE12dPncSLLfy%2BRbgiP5XWEdipwGRCCWPP3jXq%2FhL4D%2BGfDtxFeai8mtXaIylLqJRbkk8MIsHkLx8zMM5OAcY9UooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA%2F%2F9k%3D";
        if(imageDataB64 != null){
            imageDataB64 = "imageData={\"imageDataB64\": \"" + imageDataB64 + "\"}";
        }
        restServiceAdapter.setRequestURI(restURI);        
        restServiceAdapter.setRetryLimit(0);    
        
        //variable holding the response
        String response = "";
        
        
        try {
            response = (String) restServiceAdapter.send(imageDataB64);
        } catch (Exception e) {
            //log error
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", "Invoke of REST Resource failed for "+RestServiceAdapter.REQUEST_TYPE_POST+" to "+restURI);
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", e.getLocalizedMessage());
        }
        Map pageFlow = (Map)AdfmfJavaUtilities.evaluateELExpression("#{pageFlowScope}");
        pageFlow.put("pPhotoUploadStatus", imageDataB64);
    }
}
