package engine.graphix;

import engine.GameSettings;
import engine.items.GameItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scene {

    private Map<Mesh, List<GameItem>> meshMap;
    private SkyBox skyBox;
    private SceneLight sceneLight;
    private Fog fog;

    public Scene() {
        meshMap = new HashMap();
        fog = Fog.NOFOG;
    }

    public Map<Mesh, List<GameItem>> getGameMeshes() {
        return meshMap;
    }

    public void setGameItems(GameItem[] gameItems) {
        int numGameItems = gameItems != null ? gameItems.length : 0;
        for (int i=0; i<numGameItems; i++) {
            GameItem gameItem = gameItems[i];
            Mesh mesh = gameItem.getMesh();
            List<GameItem> list = meshMap.get(mesh);
            if ( list == null ) {
                list = new ArrayList<>();
                meshMap.put(mesh, list);
            }
            list.add(gameItem);
        }
    }

    public SkyBox getSkyBox() {
        return skyBox;
    }

    public void setSkyBox(SkyBox skyBox) {
        this.skyBox = skyBox;
    }

    public void setTexParam(int pname, int param){
        for(Mesh mesh: meshMap.keySet()) {
            Material m = mesh.getMaterial();
            if (m.isTextured()){
                m.getTexture().setTexParam(pname, param);
            }
        }
    }

    public SceneLight getSceneLight() {
        return sceneLight;
    }

    public void setSceneLight(SceneLight sceneLight) {
        this.sceneLight = sceneLight;
    }

    public Fog getFog() {
        if (GameSettings.isFOG())
            return fog;
        else
            return Fog.NOFOG;
    }

    public void setFog(Fog fog) {
        this.fog = fog;
    }

    public void cleanup() {
        for (Mesh mesh : meshMap.keySet()) {
            mesh.cleanUp();
        }
    }
}
