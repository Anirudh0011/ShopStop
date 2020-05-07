package adventures.com.shopstop;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class permissionss {

    Context mContext;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 123;

    public static void checkPermission(final Context mContext, final Activity mActivity){

        if(ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
                + ContextCompat.checkSelfPermission(
                mContext,Manifest.permission.READ_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(
                mContext,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(
                mContext,Manifest.permission.CALL_PHONE)
                + ContextCompat.checkSelfPermission(
                mContext,Manifest.permission.SEND_SMS)
                + ContextCompat.checkSelfPermission(
                mContext,Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED){



            // Do something, when permissions not granted
            if(ActivityCompat.shouldShowRequestPermissionRationale(
                    mActivity,Manifest.permission.CAMERA)
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    mActivity,Manifest.permission.READ_EXTERNAL_STORAGE)
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    mActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE)
             || ActivityCompat.shouldShowRequestPermissionRationale(
                    mActivity,Manifest.permission.CALL_PHONE)
             || ActivityCompat.shouldShowRequestPermissionRationale(
                    mActivity,Manifest.permission.SEND_SMS)){

                // If we should give explanation of requested permissions

                // Show an alert dialog here with request explanation
                AlertDialog.Builder builder = new AlertDialog.Builder( mActivity);
                builder.setMessage("Camera, Read Contacts and Write External" +
                        " Storage permissions are required to do the task.");
                builder.setTitle("Please grant those permissions");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(
                                mActivity,
                                new String[]{
                                        Manifest.permission.CAMERA,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.CALL_PHONE,
                                        Manifest.permission.SEND_SMS,
                                        Manifest.permission.INTERNET,
                                },
                                MY_PERMISSIONS_REQUEST_CODE
                        );
                    }
                });
                builder.setNeutralButton("Cancel",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }else{
                // Directly request for required permissions, without explanation
                ActivityCompat.requestPermissions(
                        mActivity,
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.INTERNET,
                        },
                        MY_PERMISSIONS_REQUEST_CODE
                );
            }
        }
    }
}
