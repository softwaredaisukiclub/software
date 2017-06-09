cd ..
cp -r app sjis_app
nkf -s --overwrite sjis_app/server/front/*
nkf -s --overwrite sjis_app/server/serverside/*
nkf -s --overwrite sjis_app/client/front/*
nkf -s --overwrite sjis_app/client/serverside/*