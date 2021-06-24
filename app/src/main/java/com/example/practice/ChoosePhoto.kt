package com.example.practice

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class ChoosePhoto : Fragment() {



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val choose: Button? = view?.findViewById<Button?>(R.id.btnChoose)
        val take: Button? = view?.findViewById<Button?>(R.id.btnTake)

        choose?.setOnClickListener{
            var intent =Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent,456)
        }

        take?.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,123)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView: ImageView? = view?.findViewById<ImageView?>(R.id.imageViewChoosePhoto)
        if (requestCode == 123){
            var bmp: Bitmap
            if (data?.extras?.get("data")!=null) {
                bmp = data?.extras?.get("data") as Bitmap
                imageView?.setImageBitmap(bmp)
            }

        }else if(requestCode == 456){
            imageView?.setImageURI(data?.data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_photo, container, false)
    }


}