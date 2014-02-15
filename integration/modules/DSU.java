package appeng.integration.modules;

import net.minecraft.tileentity.TileEntity;
import powercrystals.minefactoryreloaded.api.IDeepStorageUnit;
import appeng.api.AEApi;
import appeng.api.storage.IMEInventory;
import appeng.integration.IIntegrationModule;
import appeng.integration.abstraction.IDSU;
import appeng.integration.modules.helpers.MFRDSU;
import appeng.integration.modules.helpers.MFRDSUHandler;

public class DSU implements IIntegrationModule, IDSU
{

	public static DSU instance;

	@Override
	public IMEInventory getDSU(TileEntity te)
	{
		return new MFRDSU( te );
	}

	@Override
	public boolean isDSU(TileEntity te)
	{
		if ( te instanceof IDeepStorageUnit )
			return true;
		return false;
	}

	@Override
	public void Init()
	{

	}

	@Override
	public void PostInit()
	{
		AEApi.instance().registries().externalStorage().addExternalStorageInterface( new MFRDSUHandler() );
	}

}