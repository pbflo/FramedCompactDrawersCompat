package eutros.framedcompactdrawers;

import eutros.framedcompactdrawers.integration.IntegrationRegistry;
import eutros.framedcompactdrawers.proxy.IProxy;
import eutros.framedcompactdrawers.utils.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        dependencies = "required-after:storagedrawers;required-after:chameleon;"
)
public class FramedCompactDrawers {

    public static IntegrationRegistry integrationRegistry = new IntegrationRegistry();

    @SidedProxy(modId = Reference.MOD_ID, clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent evt) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent evt) {
        proxy.init();
        integrationRegistry.init();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent evt) {
        proxy.postInit();
        integrationRegistry.postInit();
    }

}
