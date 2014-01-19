package nittyan.nfc;

import android.app.Activity;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateBeamUrisCallback;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcAdapter.OnNdefPushCompleteCallback;
import android.nfc.NfcEvent;
import android.os.Bundle;

/**
 * 
 * @see http://developer.android.com/guide/topics/connectivity/nfc/index.html
 *
 */
public abstract class NfcAdaptiveActivity extends Activity implements CreateBeamUrisCallback, OnNdefPushCompleteCallback, CreateNdefMessageCallback {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
		if (null == adapter) {
			throw new RuntimeException("No NfcAdapter");
		} else {
			adapter.setOnNdefPushCompleteCallback(this, this);
		}
	}
	
	protected void sendLightData() {
		NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
		adapter.setNdefPushMessageCallback(this, this);
		adapter.setBeamPushUrisCallback(null, this);		
	}
	
	protected void sendHeavyData() {
		NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
		adapter.setNdefPushMessageCallback(null, this);
		adapter.setBeamPushUrisCallback(this, this);
	}

	@Override
	public NdefMessage createNdefMessage(NfcEvent event) {
		return this.realCreateNdefMessage(event);
	}
	
	/**
	 * Please override when use sendLightData
	 * @param event
	 * @return
	 */
	protected NdefMessage realCreateNdefMessage(NfcEvent event) {
		throw new RuntimeException("Implement realCreateNdefMessage!");
	}

	@Override
	public Uri[] createBeamUris(NfcEvent event) {
		return this.realCreateBeamUris(event);
	}
	
	protected Uri[] realCreateBeamUris(NfcEvent event) {
		throw new RuntimeException("Implement realCreateBeamUris!");
	}

	@Override
	public void onNdefPushComplete(NfcEvent event) {
		this.realOnNdefPushComplete(event);
	}	
	
	protected void realOnNdefPushComplete(NfcEvent event) {
		throw new RuntimeException("Implement realOnNdefPushComplete!");		
	}

}
